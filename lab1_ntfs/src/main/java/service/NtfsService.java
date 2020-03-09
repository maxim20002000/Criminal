package service;

import entity.Data;

public interface NtfsService {

    Data parse(int offset, String fileName);
}
