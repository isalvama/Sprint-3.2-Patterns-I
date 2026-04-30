package second_level.model.concrete_models;

import java.text.Normalizer;

public enum SpanishProvince {
    A_CORUNA("A Coruña"),
    ALAVA("Álava"),
    ALBACETE("Albacete"),
    ALICANTE("Alicante"),
    ALMERIA("Almería"),
    ASTURIAS("Asturias"),
    AVILA("Ávila"),
    BADAJOZ("Badajoz"),
    BALEARES("Illes Balears"),
    BARCELONA("Barcelona"),
    BIZKAIA("Bizkaia"),
    BURGOS("Burgos"),
    CACERES("Cáceres"),
    CADIZ("Cádiz"),
    CANTABRIA("Cantabria"),
    CASTELLON("Castellón"),
    CEUTA("Ceuta"),
    CIUDAD_REAL("Ciudad Real"),
    CORDOBA("Córdoba"),
    CUENCA("Cuenca"),
    GIPUZKOA("Gipuzkoa"),
    GIRONA("Girona"),
    GRANADA("Granada"),
    GUADALAJARA("Guadalajara"),
    HUELVA("Huelva"),
    HUESCA("Huesca"),
    JAEN("Jaén"),
    LA_RIOJA("La Rioja"),
    LAS_PALMAS("Las Palmas"),
    LEON("León"),
    LLEIDA("Lleida"),
    LUGO("Lugo"),
    MADRID("Madrid"),
    MALAGA("Málaga"),
    MELILLA("Melilla"),
    MURCIA("Murcia"),
    NAVARRA("Navarra"),
    OURENSE("Ourense"),
    PALENCIA("Palencia"),
    PONTEVEDRA("Pontevedra"),
    SALAMANCA("Salamanca"),
    SANTA_CRUZ_DE_TENERIFE("Santa Cruz de Tenerife"),
    SEGOVIA("Segovia"),
    SEVILLA("Sevilla"),
    SORIA("Soria"),
    TARRAGONA("Tarragona"),
    TERUEL("Teruel"),
    TOLEDO("Toledo"),
    VALENCIA("Valencia"),
    VALLADOLID("Valladolid"),
    ZAMORA("Zamora"),
    ZARAGOZA("Zaragoza");

    private final String name;

    SpanishProvince(String name) { this.name = name; }

    public static boolean isValid(String name) {
        if (name == null) return false;
        String normalizedSearch = normalize(name);
        for (SpanishProvince p : values()) {
            if (normalize(p.name).equals(normalizedSearch)) return true;
        }
        return false;
    }

    private static String normalize(String text) {
        String n = Normalizer.normalize(text, Normalizer.Form.NFD);
        return n.replaceAll("\\p{M}", "").toLowerCase().trim();
    }
}
