create proc usp_QuerySelectSubjectIdAndGroupId
        @studentActionId bigint,
        @subjectId varchar out,
        @groupId varchar out,
        @table varchar(50)
        as
    begin
      declare @sql nvarchar(MAX)
      set @sql = N'select '
                  + @subjectId+ ' = subject_id '
                  + @groupId + ' = group_id ' +
                  'from ' + @table  + ' where '
                  + cast(@studentActionId as varchar) + ' = student_id'
      exec sp_executesql @sql
    end
go

