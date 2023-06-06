package com.example.ProjectVac.DTO.RequestDTO;

import com.example.ProjectVac.Enum.Center;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class VcenterRequestDTO {
    Center type;
    String location;
    String name;
}
