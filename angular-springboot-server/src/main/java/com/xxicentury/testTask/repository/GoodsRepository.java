package com.xxicentury.testTask.repository;

import com.xxicentury.testTask.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Long> { Goods findGoodsByName (String name);
}
