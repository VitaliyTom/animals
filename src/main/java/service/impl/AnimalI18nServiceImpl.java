package service.impl;

import converter.Converter;
import dao.AnimalDao;
import dao.AnimalI18nDao;
import dto.AnimalDtoByteMedia;
import dto.AnimalI18nDto;
import entity.Animal;
import entity.AnimalI18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AnimalI18nService;

@Service("animalI18nService")
public class AnimalI18nServiceImpl implements AnimalI18nService {

    @Autowired
    AnimalI18nDao animalI18nDao;
    @Autowired
    AnimalDao animalDao;

    @Override
    public AnimalDtoByteMedia getIdAjaxI18n(AnimalI18nDto animalI18nDto) {
        Converter cnvrt = new Converter();
        Animal animal = animalDao.read(animalI18nDto.getIdAnimals());
        AnimalI18n animalI18n = animalI18nDao.getId(cnvrt.converterAnimalI18nDtoToAnimalI18n(animalI18nDto));
        AnimalDtoByteMedia animalDtoByteMedia = cnvrt.converterAnimalToAnimalDtoByteMedia(animalI18n, animal);

        return animalDtoByteMedia;
    }
}