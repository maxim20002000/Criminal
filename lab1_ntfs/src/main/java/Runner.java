import entity.Data;
import service.NtfsService;
import service.NtfsServiceImpl;

public class Runner {

    public static void main(String[] args) {
        NtfsService service = new NtfsServiceImpl();
        Data data = service.parse(0, "ntfs-img-kw-1.dd");
        System.out.println(data.toString());
    }
}
