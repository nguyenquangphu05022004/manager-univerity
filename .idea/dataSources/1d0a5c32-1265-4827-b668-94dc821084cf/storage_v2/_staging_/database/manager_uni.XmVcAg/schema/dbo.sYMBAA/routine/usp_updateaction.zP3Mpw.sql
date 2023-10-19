create proc usp_UpdateAction(
  @studentRequestId bigint, @studentResponseId bigint
) as
  begin
    declare @requestId bigint

    select @requestId = sr1.id
    from student_request sr1
           inner join student_response sr2 on sr1.student_id = sr2.student_id and sr1.subject_id = sr2.subject_id
    where sr2.id = @studentResponseId

    delete from student_response_request where student_request = @requestId

    delete from student_request where id = @requestId

    delete from student_response where id not in (select student_response from student_response_request)

    delete from student_response_request
    where student_response in (select sr1.id
                               from student_response sr1
                                      inner join student_response sr2 on sr1.student_id = sr2.student_id
                                                                           and sr1.subject_id = sr2.subject_id
                                                                           and sr1.group_id = sr2.group_id and
                                                                         sr1.status = 'false'
                               where sr2.id = @studentResponseId)

    delete sr1
    from student_response sr1
           inner join student_response sr2 on sr1.student_id = sr2.student_id
                                                and sr1.subject_id = sr2.subject_id
                                                and sr1.group_id = sr2.group_id and sr1.status = 'false'
    where sr2.id = @studentResponseId

  end
go

