package com.ninjarmm.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ninjarmm.app.entity.device.Device;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("deviceRepository")
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByIdCustomer(Long idCustomer);
}

