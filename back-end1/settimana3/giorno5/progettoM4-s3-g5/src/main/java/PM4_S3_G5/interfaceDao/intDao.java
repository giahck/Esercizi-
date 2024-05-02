package PM4_S3_G5.interfaceDao;

public interface intDao {
    void insert(Object o);
    void update(Object o);
    void delete(Object o);
    Object findById(Object o);
    Object findAll();
}
