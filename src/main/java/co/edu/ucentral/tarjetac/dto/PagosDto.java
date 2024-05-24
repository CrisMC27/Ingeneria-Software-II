package co.edu.ucentral.tarjetac.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class PagosDto implements Serializable {
    private long serial;
    private long numerotar;
    private long monto;
}
