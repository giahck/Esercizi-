package it.epicode.u5w7d2teoria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    @NotBlank(message = "the name cannot be empty or missing or composed of only spaces")
    private String name;
    @NotBlank(message = "the surname cannot be empty or missing or composed of only spaces")
    private String surname;
    @NotNull(message = "the birth date cannot be empty or missing or composed of only spaces")
    private LocalDate birthDate;
}
