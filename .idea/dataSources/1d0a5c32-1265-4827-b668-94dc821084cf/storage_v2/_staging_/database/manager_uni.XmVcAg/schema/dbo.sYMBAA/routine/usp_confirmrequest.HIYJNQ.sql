create   proc usp_ConfirmRequest(
    @studentRequestId bigint,
    @studentResponseId bigint,
    @result bit out
  )
  as
    begin
      declare @checkIsEmpty bit;
      begin
        exec @checkIsEmpty = usp_CheckResponseIsEmpty
            @studentRequestId, @studentResponseId
      end
      if(@checkIsEmpty = 1)
        begin
          declare @subjectRequestId bigint, @groupRequestId bigint, @studentIdRequest bigint;
          declare @subjectResponseId bigint, @groupResponseId bigint, @studentIdResponse bigint;
          begin
            select
                   @subjectRequestId = subject_id,
                   @groupRequestId = group_id,
                   @studentIdRequest =student_id
            from student_request where id = @studentRequestId
            print(@groupRequestId)
            print(@studentIdRequest)
            print(@subjectRequestId)

          end
          begin
            select
                   @subjectResponseId = subject_id,
                   @groupResponseId = group_id,
                   @studentIdResponse = student_id
            from student_response where id = @studentResponseId
            print(@groupResponseId)
            print(@studentIdResponse)
            print(@subjectResponseId)
          end

          begin
            update register
            set group_id = @groupResponseId
            where student_id = @studentIdRequest and subject_id = @subjectRequestId
            update register
            set group_id = @groupRequestId
            where student_id = @studentIdResponse and subject_id = @subjectResponseId
            set @result = 'true'
          end
        end

      else
        begin
          set @result = 'false'
        end
    end
go

