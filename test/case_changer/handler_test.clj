(ns case-changer.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [case-changer.handler :refer :all]))


(deftest sanity
  (is true))

(deftest test-say-hi
  (are [exp input] (= exp (say-hi input))
    nil "dogman"
    "Hi, Jason!" "Jason"
    "Hi, brah!" nil))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hi, brah!")))))
