package entity;

public class Data {

    private int bytesPerSector;
    private int sizeOfMFTEntry;
    private int sectorsPerCluster;
    private long MftStart;
    private String serialNumber;
    private long totalSectors;
    private long MftMirrorStart;
    private String oem;
    private int mediaDescriptor;

    public void setBytesPerSector(int bytesPerSector) {
        this.bytesPerSector = bytesPerSector;
    }

    public void setSectorsPerCluster(int sectorsPerCluster) {
        this.sectorsPerCluster = sectorsPerCluster;
    }

    public void setMftStart(long mftStart) {
        MftStart = mftStart;
    }

    public void setSizeOfMFTEntry(int sizeOfMFTEntry) {
        this.sizeOfMFTEntry = sizeOfMFTEntry;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setTotalSectors(long totalSectors) {
        this.totalSectors = totalSectors;
    }

    public void setMftMirrorStart(long mftMirrorStart) {
        MftMirrorStart = mftMirrorStart;
    }

    public void setOem(String oem) {
        this.oem = oem;
    }

    public void setMediaDescriptor(int mediaDescriptor) {
        this.mediaDescriptor = mediaDescriptor;
    }

    @Override
    public String toString() {
        return "Data:" +
                "  \n bytesPerSector=" + bytesPerSector +
                "  \n sizeOfMFTEntry=" + sizeOfMFTEntry +
                "  \n sectorsPerCluster=" + sectorsPerCluster +
                "  \n MftStart=" + MftStart +
                "  \n serialNumber='" + serialNumber + '\'' +
                "  \n totalSectors=" + totalSectors +
                "  \n MftMirrorStart=" + MftMirrorStart +
                "  \n oem='" + oem + '\'' +
                "  \n mediaDescriptor=" + mediaDescriptor;
    }
}
