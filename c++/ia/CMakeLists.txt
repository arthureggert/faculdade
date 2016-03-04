cmake_minimum_required(VERSION 3.2)
project(ia)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES NNFpp.cpp rna.cpp el1.jpg)

find_package( OpenCV REQUIRED )

add_executable(ia ${SOURCE_FILES})
target_link_libraries( ia ${OpenCV_LIBS} )