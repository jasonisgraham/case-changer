(ns case-changer.core)

(defn say-hi [name]
  (when-not (= "dogman" name)
    (let [name (or name "brah")]
      (str "Hi, " name "!"))))
