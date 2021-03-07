package pl.sda.javalondek4springdemo.converter;

public interface Mapper<E, D> {

    D fromEntityToDto(E entity);

    E fromDtoToEntity(D dto);
}
