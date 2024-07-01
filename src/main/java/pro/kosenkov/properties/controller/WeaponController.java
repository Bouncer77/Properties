package pro.kosenkov.properties.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.kosenkov.properties.entity.Weapon;
import pro.kosenkov.properties.properties.yml.YAMLConfig;
import pro.kosenkov.properties.repository.WeaponRepository;

import java.time.Instant;
import java.util.List;

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor
public class WeaponController {

    @Autowired
    private YAMLConfig yamlConfig;

    private final WeaponRepository repository;

    @GetMapping(value = "/weapons")
    public List<Weapon> getAllWeapons() {
        System.out.println("yamlConfig.getName(): " + yamlConfig.getName());

        List<String> servers = yamlConfig.getServers();
        System.out.println("Servers: " + servers);

        YAMLConfig.Service service = yamlConfig.getComponent().getService();
        System.out.println("Service:");
        System.out.println("   Url: " + service.getUrl());
        System.out.println("   Token: " + service.getToken());
        System.out.println("   Description: " + service.getDescription());

        return repository.findAll();
    }

    @GetMapping(value = "/weapon")
    public Weapon getWeaponByName(String name) {
        long curDate = Instant.now().getEpochSecond();
        System.out.println("Instant.now().getEpochSecond() = " + curDate);
        return repository.findByNameAndStartDateLessThanEqualAndEndDateGreaterThanEqual(name, curDate, curDate);
    }

    @GetMapping(value = "/kit_start")
    public String insertTestWeapons() {
        // Sat Jun 25 2022 14:47:16 GMT+0300 (Москва, стандартное время) = 1656157636
        // Tue Jun 25 2024 14:47:16 GMT+0300 (Москва, стандартное время) = 1719316036
        // Fri Jun 25 2027 14:47:16 GMT+0300 (Москва, стандартное время) = 1813924036
        Weapon shotgun = new Weapon(1L, "MP-133", 1656157636, 1687438715);
        Weapon shotgun2 = new Weapon(3L, "MP-133", 1687438716, 1813924036);
        Weapon traumaticPistol = new Weapon(2L, "Травматический пистолет МР-79-9 ТМ (кал.9мм Р.А.)", 1656157636, 1719316036);
        List<Weapon> kitStart = List.of(shotgun, traumaticPistol, shotgun2);
        repository.saveAll(kitStart);
        return "Шалость удалась";
    }
}
