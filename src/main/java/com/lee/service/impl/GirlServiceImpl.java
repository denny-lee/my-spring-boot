package com.lee.service.impl;

import com.lee.dao.GirlMapper;
import com.lee.dao.GirlRepository;
import com.lee.entity.GirlEntity;
import com.lee.model.CountPojo;
import com.lee.model.Girl;
import com.lee.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GirlServiceImpl implements GirlService {
//    @Autowired
//    private GirlMapper mapper;
    @Override
    public void save(Girl girl) {
        System.out.println("------=========---------");
//        mapper.save(girl);
    }

    @Autowired
    private GirlRepository girlRepository;

    @Override
    public List<CountPojo> queryNative() {
        return girlRepository.queryNative();
    }

    @Override
    public List<GirlEntity> query(GirlEntity entity) {
        return girlRepository.findAll(getSpec(entity));
    }

    @Override
    public void saveOrUpdate(GirlEntity girlEntity) {
        girlRepository.save(girlEntity);
    }

    @Override
    public int updateSpec(Integer oldAge, Integer newAge, String name) {
        return girlRepository.updateAge(oldAge, newAge, name);
    }

    private Specification<GirlEntity> getSpec(final GirlEntity entity) {
        return (Root<GirlEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.equal(root.get("age"), entity.getAge());
            Predicate p2 = criteriaBuilder.like(root.get("name"), entity.getName() + "%");
            Predicate p3 = criteriaBuilder.equal(root.join("boyFriends", JoinType.INNER).get("age"), 48);
            return criteriaQuery.where(p1, p2, p3).getRestriction();
        };
    }

    @Override
    @Transactional(readOnly = true)
    public List<GirlEntity> queryByNickName(String nickName) {
        List<GirlEntity> gs = girlRepository.findAllByNickName(nickName);
        return gs;
    }
}
