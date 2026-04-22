package second_level.countries.spain;

import second_level.model.Address;
import second_level.core.validator.AddressValidator;
import second_level.core.exception.InvalidAddressException;
import second_level.model.SpanishAddress;

import java.text.Normalizer;
import java.util.List;

public class SpainAddressValidator implements AddressValidator {
    private static final List<String> provinces = List.of(
            "A Coruña", "Álava", "Albacete", "Alicante", "Almería", "Asturias",
            "Ávila", "Badajoz", "Barcelona", "Bizkaia", "Burgos", "Cáceres",
            "Cádiz", "Cantabria", "Castellón", "Ciudad Real", "Córdoba", "Cuenca",
            "Gipuzkoa", "Girona", "Granada", "Guadalajara", "Huelva", "Huesca",
            "Illes Balears", "Jaén", "La Rioja", "Las Palmas", "León", "Lleida",
            "Lugo", "Madrid", "Málaga", "Murcia", "Navarra", "Ourense", "Palencia",
            "Pontevedra", "Salamanca", "Santa Cruz de Tenerife", "Segovia", "Sevilla",
            "Soria", "Tarragona", "Teruel", "Toledo", "Valencia", "Valladolid",
            "Zamora", "Zaragoza", "Ceuta", "Melilla"
    );


    @Override
    public Address validateAddress(Address address) {
        if (!(address instanceof SpanishAddress spanishAddress)) throw new InvalidAddressException("Invalid address: address is not an instance of SpanishAddress class", address.getClass().getSimpleName(), "fieldType");
        if (!validateProvinceName(spanishAddress.getProvince())) throw new InvalidAddressException("Invalid Spanish address: province does not exist", spanishAddress.getProvince(), "province");
        validatePostalCode(spanishAddress);
        return address;
    }

    private boolean validateProvinceName (String provinceName) {
        String cleanProvinceName = cleanString(provinceName);
        return provinces.stream().anyMatch(
                p -> p.equalsIgnoreCase(cleanProvinceName)
        );
    }

    private String cleanString(String text) {
        if (text == null) return null;
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "").toLowerCase();
    }

    private void validatePostalCode(SpanishAddress address){
        if (!address.getPostalCode().matches("[0-9]{5}")) throw new InvalidAddressException("Invalid Spanish address: postal code must contain 5 digits", address.getPostalCode(), "postalCode");
        if (Integer.parseInt(address.getPostalCode().substring(0, 2)) > 52) throw new InvalidAddressException("Invalid Spanish address: postal code does not exist", address.getPostalCode(), "postalCode");
    }
}
