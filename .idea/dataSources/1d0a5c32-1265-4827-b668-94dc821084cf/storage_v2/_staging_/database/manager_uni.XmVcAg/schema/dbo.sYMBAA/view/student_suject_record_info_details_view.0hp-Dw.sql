create view student_suject_record_info_details_view
  as
    (
    select
           sj.id as id, sj.subjectname as subjectname,
           se.status as status,
           sj.credit as credit, g.code as groupcode,
           sj.start_date as startdate, sj.end_date as enddate
    from groups g inner join subjects sj
             on g.id = sj.group_id
                  inner join student_subject ss
             on sj.id = ss.subject_id
                  inner join students s on s.id = ss.student_id
                  left join subject_exchange se
             on se.subject_id = ss.subject_id

    )
go

