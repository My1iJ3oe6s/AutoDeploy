package cn.joes.repository;

import cn.joes.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by myijoes on 2018/6/22.
 *
 * findBy可以结合关键字进行条件查询
 *
 * Like                 findByCityNameLike          where city_name like ?
 * And                  findByCityNameAndId         where city_name = ?1 and id = ?2
 * Or                   findByIdOrCityName          where id = ?1 or city_name = ?2
 * Between              findByCreateTimeBetween     where create_time between ?1 and ?2
 * LessThan             findByIdLessThan            where id < ?1
 * GreaterThan          findByIdGreaterThan         where id > ?1
 * IsNull               findByCityNameIsNull        where city_name is NULL
 * IsNotNull,NotNull    findByCityNameNotNull       where city_name not null
 * NotLike              findByCityNameNotLike       where city_name not like ?
 * OrderBy              findByCityNameOrderByAge    where city_name = ?1 order by age desc
 * Not                  findByIdNot                 where id <> ?1
 * In                   findByAgeIn(List<Age>)      where age in ?1
 * NotIn                findByAgeNotIn(List<Age>)   where age not in ?1
 *
 */
public interface CityRepository extends JpaRepository<City, Long>{

    City findByCityName(String cityName);

    City findById(Long id);

    City findByProvinceId(Long provinceId);

    City findByTestTestTestTest(String testTestTestTest);

    List<City> findByCityNameLike(String cityName);
}
