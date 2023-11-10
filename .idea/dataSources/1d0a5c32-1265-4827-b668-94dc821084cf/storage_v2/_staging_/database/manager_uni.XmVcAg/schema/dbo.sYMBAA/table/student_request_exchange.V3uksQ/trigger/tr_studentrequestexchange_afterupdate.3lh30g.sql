CREATE trigger TR_StudentRequestExchange_AfterUpdate
  on student_request_exchange
  after update
as
  begin
    begin transaction
    declare @studentExchangeRegisterId BIGINT;
    select @studentExchangeRegisterId = r1.student_exchange
    from
         inserted ins,
         student_request_student_exchange_register r1
    where r1.student_request = ins.id

    delete from student_request_student_exchange_register
    where student_exchange = @studentExchangeRegisterId
      and student_request != (select ins.id from inserted ins)


    -- sử lý xóa phần request
--     delete from student_request_exchange
--     where id not in (select from )



    --TODO: XỬ LÝ KHI MÔN HỌC ĐÃ ĐƯỢC ĐỔI NHƯNG TRONG PHẦN TRAO ĐỔI VẪN TỒN TẠI
    declare @studentExchangeId BIGINT
    select @studentExchangeId = ser.id
    from student_exchange_register ser,
                 inserted ins
    where ser.student_id = ins.student_id
      and ser.register_id = ins.register_id

    delete from student_request_student_exchange_register where student_exchange = @studentExchangeId

    delete from student_exchange_register where id = @studentExchangeId

    delete from student_request_exchange
    where id not in (select r.student_request from student_request_student_exchange_register r)
    commit ;
  end
go

