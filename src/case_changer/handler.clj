(ns case-changer.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))


(defn say-hi [name]
  (when-not (= "dogman" name)
    (let [name (or name "brah")]
      (str "Hi, " name "!"))))

(defroutes app-routes
  (GET "/:name" [name] (say-hi name))

  (GET "/" [] (say-hi nil))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
