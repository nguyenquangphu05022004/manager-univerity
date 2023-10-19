create view vw_state_subject
  as
  (select
          sj.id as id, sj.subjectname as subjectname,
          se.status as status,
          sj.credit as credit, g.code as groupcode,
          sj.start_date as startdate, sj.end_date as enddate,
          s.username as username,
          sj.subject_id as subjectid,
          se.id as idsubjectexchange
   from groups g inner join subjects sj
            on g.id = sj.group_id
                 inner join student_subject ss
            on sj.id = ss.subject_id
                 inner join students s on s.id = ss.student_id
                 left join subject_exchange se
            on se.subject_id = ss.subject_id
  )
go

