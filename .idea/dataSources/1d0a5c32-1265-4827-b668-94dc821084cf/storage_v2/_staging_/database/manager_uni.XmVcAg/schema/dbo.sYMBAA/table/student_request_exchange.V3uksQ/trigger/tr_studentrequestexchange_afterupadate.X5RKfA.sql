alter trigger TR_StudentRequestExchange_AfterUpadate
  on student_request_exchange
  after update
as
  begin
    declare @studentExchangeRegisterId BIGINT
    declare @studentId bigint, @registerId bigint;

    --Mã của exchange của thằng sinh viên mà nó gửi request
    declare @studentExchangeRegisterId1 bigint;

    select
      @studentExchangeRegisterId1 = s1.id
    from
         inserted ins,
         student_exchange_register s1
    where ins.student_id = s1.student_id and ins.register_id = s1.register_id


    select
           @studentExchangeRegisterId = ins.student_exchange_register_id ,
           @studentId = ins.student_id,
          @registerId = ins.register_id
    from inserted ins


    delete from student_request_exchange
    where (student_exchange_register_id = @studentExchangeRegisterId
             and status_exchange = 'false')
      or (student_id = @studentId and register_id = @registerId and status_exchange = 'false')
    or (student_exchange_register_id = @studentExchangeRegisterId1)
    ;

    delete from student_exchange_register
    where id = @studentExchangeRegisterId1

  end
go

