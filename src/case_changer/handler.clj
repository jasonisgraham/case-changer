(ns case-changer.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [case-changer.core :as cc]))

(defroutes app-routes
  (GET "/say-hi/:name" [name] (cc/say-hi name))
  (GET "/do-env-vars-work" []
       (str "ENV_VAR_TEST : " (System/getenv "ENV_VAR_TEST")))

  (GET "/" [] (cc/say-hi nil))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
