package com.jcode.sawiya.service;


import com.jcode.sawiya.dto.ResponseDTO;
import java.text.ParseException;

/**
 * Created by Thakshila Bandara
 * Date: Dec 27, 2023.
 * Time: 9:45:00 AM
 * Project: Sawiya | Volunteer
 */
public interface RepresentativeService {
    ResponseDTO representativeRegister() throws ParseException;
}
