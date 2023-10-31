package edu.eri.cargo_management.VO;

import edu.eri.cargo_management.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Department department;
    private Teacher teacher;
}
