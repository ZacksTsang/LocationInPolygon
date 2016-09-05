(ns com.zt.polygon.location)

(defn point-in-polygon?
  "location is in polygon"
  [lat lng polygon]
  (odd? (count
    (for [item (map vector polygon (let [head (first polygon)] (conj (vec (rest polygon)) head)))
      :when (and
              (not=
                (> (get-in item [0 1]) lat)
                (> (get-in item [1 1]) lat))
              (< lng (+ (/ (* (- (get-in item [1 0]) (get-in item [0 0])) (- lat (get-in item [0 1]))) (- (get-in item [1 1]) (get-in item [0 1]))) (get-in item [0 0]))))]
    item))))

(defn reverse-geocoder
  "fetch country code by lat and lng"
  [lat lng polygonList]
  (if (and
        (not= lat nil)
        (not= lng nil))
      (let [result (for [item polygonList
              :when (=
                (if (= (get-in item ["geometry" "type"] "") "Polygon")
                  (point-in-polygon? lat lng (get-in item ["geometry" "coordinates" 0]))
                  (if (= (get-in item ["geometry" "type"] "") "MultiPolygon")
                    (>
                      (count
                        (for [polygon-item (get-in item ["geometry" "coordinates"] [])
                          :when (point-in-polygon? lat lng (get-in polygon-item [0] []))] polygon-item)) 0)
                    false)) true)] item)]
        (if (> (count result) 0) (get-in (vec result) [0 "iso_a2"] nil) nil))))
