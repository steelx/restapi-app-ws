package com.ajinkya.app.ws.io.dao.implementation;

import com.ajinkya.app.ws.io.dao.DAO;
import com.ajinkya.app.ws.io.entity.UserEntity;
import com.ajinkya.app.ws.shared.dto.UserDTO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MySqlDAO implements DAO {

    private Session session;

    @Override
    public void openConnection() {
        return;
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        UserDTO userDto = null;

        CriteriaBuilder cb = session.getCriteriaBuilder();

        //create criteria against particular persistent class
        CriteriaQuery<UserEntity> criteria = cb.createQuery(UserEntity.class);

        //Query root always references entity
        Root<UserEntity> profileRoot = criteria.from(UserEntity.class);
        criteria.select(profileRoot);
        criteria.where(cb.equal(profileRoot.get("email"), userName));

        // Fetch single result
        Query<UserEntity> query = session.createQuery(criteria);
        List<UserEntity> resultList = query.getResultList();

        if (resultList != null && resultList.size() > 0) {
            UserEntity userEntity = resultList.get(0);
            userDto = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDto);
        }

        return userDto;
    }

    @Override
    public void closeConnection() {

    }
}
