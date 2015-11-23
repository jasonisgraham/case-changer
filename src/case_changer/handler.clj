(ns case-changer.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))


(defn say-hi [name]
  (when-not (= "dogman" name)
    (let [name (or name "brah")]
      (str "Hi, " name "!"))))

(defroutes app-routes
  (GET "/say-hi/:name" [name] (say-hi name))
  (GET "/do-env-vars-work" []
       (str "ENV_VAR_TEST : " (System/getenv "ENV_VAR_TEST")))

  (GET "/" [] (say-hi nil))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
