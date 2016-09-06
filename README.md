# LocationInPolygon
Is location in polygon, this can use for get country code offline, the algorithm is from

> [PNPOLY - Point Inclusion in Polygon Test
W. Randolph Franklin (WRF)](https://www.ecse.rpi.edu/Homepages/wrf/Research/Short_Notes/pnpoly.html#The C Code)

## usage

```
(let [countryCode (com.zt.polygon.location/reverse-geocoder -14.280047 -178.136879 (json/read-str "[{\"name\":\"Wallis and Futuna Is.\",\"iso_a2\":\"WF\",\"iso_a3\":\"WLF\",\"geometry\":{\"type\":\"MultiPolygon\",\"coordinates\":[[[[-178.05,-14.32],[-178.1,-14.32],[-178.16,-14.31],[-178.19,-14.26],[-178.18,-14.23],[-178.14,-14.24],[-178.11,-14.28],[-178.04,-14.3],[-178.05,-14.32]]],[[[-176.16,-13.33],[-176.18,-13.34],[-176.2,-13.3],[-176.17,-13.24],[-176.15,-13.22],[-176.13,-13.27],[-176.16,-13.33]]]]}}]"))])
```

## test

```
lein test
```
