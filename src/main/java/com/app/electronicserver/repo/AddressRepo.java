package com.app.electronicserver.repo;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(value = "select address from Address address where address.user.username=:username")
    List<Address> getAddressByUsername(@Param("username") String username);
    @Modifying
    @Transactional
    @Query("DELETE  FROM Address address WHERE address.id =:id and address.user.username=:username")
    void deleteCartByIdAndUsername(@Param("id") Integer id, @Param("username") String username);
}
