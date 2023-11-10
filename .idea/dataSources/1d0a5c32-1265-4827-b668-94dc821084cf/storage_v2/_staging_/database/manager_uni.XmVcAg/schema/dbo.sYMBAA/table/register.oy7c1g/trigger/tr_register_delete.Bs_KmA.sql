create trigger TR_Register_Delete
  on register
  after delete
as
  begin
    declare @studentExchangeReigsterId BIGINT,
            @registerId BIGINT
    select 
      @registerId = del.id
    from deleted del;
    select
      @studentExchangeReigsterId = r.student_exchange_subject_id
    from student_exchange_register_register r
    where r.register_id = @registerId;

    delete
    from student_exchange_register
    where student_exchange_register.id =
          @studentExchangeReigsterId
  end
go

