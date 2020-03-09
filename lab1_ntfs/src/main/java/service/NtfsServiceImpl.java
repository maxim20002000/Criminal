package service;

import entity.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * http://www.ntfs.com/ntfs-partition-boot-sector.htm
 */
public class NtfsServiceImpl implements NtfsService {

    private FileService fileService;

    public NtfsServiceImpl() {
        fileService = new FileServiceImpl();
    }

    @Override
    public Data parse(int offset_num, String fileName) {
        Data data = new Data();
        byte[] dataInBytes = fileService.readWithSpecOffset(offset_num, new byte[512], fileName);

        ByteBuffer bootSector = ByteBuffer.wrap(dataInBytes);
        bootSector.order(ByteOrder.LITTLE_ENDIAN);

        byte[] oem = new byte[4];
        int offset = 3;
        int counter = 0;
        while (counter < oem.length) {
            oem[counter] = bootSector.get(offset);
            offset++;
            counter++;
        }

        data.setOem(new String(oem));
        data.setBytesPerSector(bootSector.getShort(11));
        data.setSectorsPerCluster(bootSector.get(13));
        data.setMediaDescriptor(0xF8 & bootSector.getInt(21));
        data.setTotalSectors(bootSector.getLong(40));
        data.setMftStart(bootSector.getLong(48));
        data.setMftMirrorStart(bootSector.getLong(56));
        data.setSizeOfMFTEntry(bootSector.get(64));

        /*
        %08x means that every number should be printed at least 8 characters wide with filling
            all missing digits with zeros, e.g. for '1' output will be 00000001
         */
        data.setSerialNumber(String.format("%08X", bootSector.getLong(72)));

        return data;
    }
}
