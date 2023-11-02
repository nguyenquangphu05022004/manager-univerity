package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class GradeDTO extends GenericDTO{
        private Long registerId;
        private RegisterDTO registerDTO;
        private Float attend;
        private Float midterm;
        private Float endOfTerm;
        private Float test;
        private Float practice;
        private Float gpa;

        public float gpa() {
                this.gpa = attend * 0.1f + midterm * 0.2f + endOfTerm * 0.7f;
                return gpa;
        }

}
