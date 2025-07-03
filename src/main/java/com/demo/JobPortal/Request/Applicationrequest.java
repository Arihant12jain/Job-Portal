package com.demo.JobPortal.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Applicationrequest {
    private Long userid;
    private Long jobid;
}
