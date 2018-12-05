package cn.joes.repository;

import cn.joes.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by myijoes on 2018/7/12.
 */
public interface City2Repository extends JpaRepository<City, Long> {

    /*@Update(value = "")
    City updateCityName(@Param("id")Integer id, @Param("cityName")String cityName);*/



    //@Query(value = "from City c where 1=  :#{#id == null  ? 1 : ' 1 and c.id '} ")
    @Query(value = "from City c where 1= 1  and c.id in ( :#{#id == null ? #id : #id}) ")
    List<City> queryById(@Param("id") List<Long> id);

    //利用原生的SQL进行删除操作
    @Query(value = "delete from city c where c.id = ?1 ", nativeQuery = true)
    @Modifying
    public void deleteById(Long id);

    //利用原生的SQL进行修改操作
    @Query(value = "update city c set c.city_name=?1 where c.id=?2 ", nativeQuery = true)
    @Modifying
    public void updateName(String cityName, Long id);

    //利用原生的SQL进行插入操作
    @Query(value = "insert into city(city_name ,description) value(?1,?2)", nativeQuery = true)
    @Modifying
    public void insertC(String name, String description);
}
