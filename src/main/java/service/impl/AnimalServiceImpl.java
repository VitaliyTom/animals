package service.impl;

import converter.Converter;
import converter.ConverterAnimalDtoByteMediaToAnimal;
import dao.AnimalDao;
import dto.AnimalDto;
import dto.AnimalDtoByteMedia;
import entity.Animal;
import entity.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.AnimalService;
import service.CategoryService;

import java.util.List;
import java.util.Random;


@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private static final Logger LOGGER = Logger.getLogger(AnimalServiceImpl.class);

    @Autowired
    AnimalDao animalDao;

    @Autowired
    CategoryService categoryService;

    @Override
    @Transactional                    //fixme разобраться!
    public void create(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.saveOrUpdate(cnvrt.animalDtoToAnimal(animalDto));

    }

    @Override
    @Transactional
    public void getIdMax(ModelMap model) {
        Animal animalIdMax = animalDao.getIdMax();

        Random rnd = new Random();
        int id = 0;
        int i = 1;
        boolean flag = true;

        while (flag) {
            //selection of an arbitrary id in the range of existing
            id = 1 + rnd.nextInt((int) animalIdMax.getAnimalId());
            Animal animal = animalDao.read((long) id);

            //we check there is an object under such id or not
            if (animal == null) {
                i++;

            } else {

                flag = false;
                LOGGER.info("найден существующий идишник c " + i + " попытки.");
                Converter cnvrt = new Converter();
                AnimalDto animalDto = cnvrt.animalToAnimalDto(animal);
                model.addAttribute("animalDto", animalDto);
            }
        }
    }

    @Override
    @Transactional
    public void delete(AnimalDto animalDto) {

        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getIdAnimal());
        animalDao.delete(animal);
    }

    @Override                       //fixme добавить апдейт на конкретные поля
    public void update(AnimalDto animalDto) {

        Converter cnvrt = new Converter();
        animalDao.saveOrUpdate(cnvrt.animalDtoToAnimal(animalDto));
    }

    @Override
    @Transactional
    public void getAll(ModelMap model) {

        List<Animal> getAll = (animalDao.getAll());
        AnimalDto animalDto = new AnimalDto();
        model.addAttribute("getAllList", getAll);
        model.addAttribute("newAnimal", animalDto);
        categoryService.getCategory(model);
//        List<Category> getAllCategory =
    }


    //fixme пересмотреть методы и лишние удалить
    @Override
    public void getId(AnimalDto animalDto, ModelMap model) {

//        Animal animal = new Animal();
//        animal.setAnimalId(animalDto.getIdAnimal());
//        Converter cnvrt = new Converter();
//        animalDto = cnvrt.animalToAnimalDto(animalDao.read(animal.getAnimalId()));
//        model.addAttribute("animalDto", animalDto);
    }

    @Override
    public AnimalDtoByteMedia getIdAjax(AnimalDtoByteMedia animalDtoByteMedia) {

        Animal animal = new Animal();
        animal.setAnimalId(animalDtoByteMedia.getIdAnimalDtoByteMedia());
        ConverterAnimalDtoByteMediaToAnimal cnvrt = new ConverterAnimalDtoByteMediaToAnimal();
        animalDtoByteMedia = cnvrt.converterAnimalToAnimalDtoByteMedia(animalDao.read(animal.getAnimalId()));

        return animalDtoByteMedia;

    }

    @Override
    public AnimalDto getId(AnimalDto animalDto) {
        Animal animal = new Animal();
        animal.setAnimalId(animalDto.getIdAnimal());
        Converter cnvrt = new Converter();
        animalDto = cnvrt.animalToAnimalDto(animalDao.read(animal.getAnimalId()));

        return animalDto;
    }
}
