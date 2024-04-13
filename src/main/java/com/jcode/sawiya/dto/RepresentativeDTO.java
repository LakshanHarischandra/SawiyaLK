package com.jcode.sawiya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Thakshila Bandara
 * Date: Dec 27, 2021.
 * Time: 9:33:04 AM
 * Project: Sawiya | Volunteer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepresentativeDTO implements Serializable {

    private Integer repId;
    private String appointedOn;
    private String retiredOn;
    private String remarks;
}
