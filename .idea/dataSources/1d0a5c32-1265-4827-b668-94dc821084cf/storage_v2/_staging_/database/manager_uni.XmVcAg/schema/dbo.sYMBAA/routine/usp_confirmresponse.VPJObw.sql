CREATE proc usp_ConfirmResponse(
  @studentRequestId  bigint,
  @studentResponseId bigint,
  @result            bit out
)
as
  begin
    declare @checkIsEmpty bit;
    begin
      exec @checkIsEmpty = usp_CheckResponseIsEmpty
          @studentRequestId, @studentResponseId
    end
    if (@checkIsEmpty = 1)
      begin
        declare @subjectRequestId bigint, @groupRequestId bigint, @studentIdRequest bigint;
        declare @subjectResponseId bigint, @groupResponseId bigint, @studentIdResponse bigint;
        begin
          select @subjectRequestId = subject_id, @groupRequestId = group_id, @studentIdRequest = student_id
          from student_request
          where id = @studentRequestId


        end
        begin
          select @subjectResponseId = subject_id, @groupResponseId = group_id, @studentIdResponse = student_id
          from student_response
          where id = @studentResponseId

        end

        begin

          update register
          set group_id = @groupResponseId
          where student_id = @studentIdRequest
            and subject_id = @subjectRequestId


          update register
          set group_id = @groupRequestId
          where student_id = @studentIdResponse
            and subject_id = @subjectResponseId
          set @result = 'true'


          update student_request set
                                     status = 'true',
                                     updateAt = GETDATE()
          where id = @studentRequestId

          update student_response set
                                      status = 'true' ,
                                      updateAt = GETDATE()
          where id = @studentResponseId


          delete from student_response_request
          where student_request = @studentRequestId
            and student_response != @studentResponseId


          delete from student_response
          where id = @studentResponseId
            and subject_id = @subjectResponseId
            and group_id != @groupResponseId



          delete from student_response_request
          where student_response in (select id
                                     from student_response
                                     where student_id = @studentIdRequest
                                       and subject_id = @subjectRequestId
                                       and group_id = @groupRequestId)

          select
              @studentIdResponse = student_id,
                 @subjectResponseId = subject_id
          from student_response where id = @studentResponseId

          delete
              from student_response_request
          where student_request = @studentResponseId

          delete
          from student_request
          where student_id = @studentIdResponse and subject_id = @subjectResponseId


          delete from student_response
          where student_id = @studentIdRequest
            and subject_id = @subjectRequestId
            and group_id = @groupRequestId

          exec usp_UpdateAction
              @studentRequestId = @studentRequestId,
              @studentResponseId = @studentResponseId
        end
      end

    else
      begin
        set @result = 'false'
      end
  end
go

