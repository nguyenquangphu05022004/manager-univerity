create view vw_select_info_request_student
  as
    select distinct
           ssei.id              as id,
           ssei.student_request as studentrequest,
           ssei.subject_request as subjectrequest,
           ssei.group_request   as grouprequest,
           s2.subjectname       as subjectname,
           s2.startdate         as startdate,
           s2.enddate           as enddate,
           g.code               as groupcode
    from student_subject s3
           inner join students s on s.id = s3.student_id
           inner join student_subject_exchange_info ssei on s.username = ssei.student_response
           inner join subjects s2 on s2.id = ssei.subject_response
           inner join subject_group s4 on s2.id = s4.subject_id
           inner join groups g on s3.group_id = g.id
          and s3.group_id = ssei.group_response
go

