create view student_subject_record_view
as
select
  se.id, s.fullname, sj.subjectname as subjectName
    , sj.subject_id as subjectCode,
    sj.start_date as startDate,
       sj.end_date as endDate
    , g.code as groupCode, sj.credit, s.id as studentId, sj.id as subjectId
from Students s inner join subject_exchange se
    on s.id = se.student_id inner join
    subjects sj on sj.id = se.subject_id
    inner join groups g on sj.group_id = g.id
where se.status = 0
go

