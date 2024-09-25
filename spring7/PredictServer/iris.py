# package import
import pandas as pd
import pickle
from sklearn.datasets import load_iris
from sklearn.neighbors import KNeighborsClassifier
from sklearn.model_selection import train_test_split

# 데이터 불러오기
iris = load_iris()
print(iris)

# DATAFRAME
iris_df = pd.DataFrame(iris['data'],columns=iris['feature_names'])
target = iris['target_names']
print(iris_df)
print(target)

# x 와 y처리
X  = iris_df
y = iris['target']

# 섞어서 나누는 작업
X_train, X_test, y_train, y_test = train_test_split(X
                                                    ,y
                                                    ,test_size=0.3
                                                    ,random_state=1)
print(y_train)

# 학습
knn_model = KNeighborsClassifier(n_neighbors=3)
knn_model.fit(X_train, y_train)

# 예측
knn_model.predict(X_test)

# Score보기
print(knn_model.score(X_test,y_test))

pred = knn_model.predict([[5.1,3.5,1.4,0.2]]) #0번데이터 세토사
print('예측결과',target[pred[0]])

