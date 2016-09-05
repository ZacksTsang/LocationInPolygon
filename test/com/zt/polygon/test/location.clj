(ns com.zt.polygon.test.location
  (:require [clojure.test :refer :all]
            [clojure.data.json :as json]
            [com.zt.polygon.location :as location]))

(deftest test-location

  (testing "location in polygon"
    (let [polygon [[75.111 22] [75.111 22.222] [76.333 22.222]] lat 22.221 lng 76.111]
      (is (= (location/point-in-polygon? lat lng polygon) true))
      (is (= (location/point-in-polygon? 25 76 polygon) false))
      (is (= (location/reverse-geocoder -14.280047 -178.136879 (json/read-str "[{\"name\":\"Wallis and Futuna Is.\",\"iso_a2\":\"WF\",\"iso_a3\":\"WLF\",\"geometry\":{\"type\":\"MultiPolygon\",\"coordinates\":[[[[-178.05,-14.32],[-178.1,-14.32],[-178.16,-14.31],[-178.19,-14.26],[-178.18,-14.23],[-178.14,-14.24],[-178.11,-14.28],[-178.04,-14.3],[-178.05,-14.32]]],[[[-176.16,-13.33],[-176.18,-13.34],[-176.2,-13.3],[-176.17,-13.24],[-176.15,-13.22],[-176.13,-13.27],[-176.16,-13.33]]]]}}]")) "WF")))))
