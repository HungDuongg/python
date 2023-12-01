import random

class ArrayMuni:
    def __init__(self, n):
        self.array = [0] * n
        '''đoạn này là gán random vào hàm define class ArrayMuni để xài phía dưới'''
        for i in range(n):
            self.array[i] = random.randint(-50, 50)

    def geti(self, i):
        try:
            return self.array[i]
        except IndexError:
            raise ArrayIndexOutOfBoundsException("Index out of bounds")

    def seti(self, i, value):
        try:
            self.array[i] = value
        except IndexError:
            raise ArrayIndexOutOfBoundsException("Index out of bounds")

    def to_string(self):
        return str(self.array)

    def subarray(self):
        max_sum = float('-inf')
        current_sum = 0
        start = 0
        end = 0
        temp_start = 0

        for i in range(len(self.array)):
            current_sum += self.array[i]

            if current_sum > max_sum:
                max_sum = current_sum
                start = temp_start
                end = i

            if current_sum < 0:
                current_sum = 0
                temp_start = i + 1

        return self.array[start:end+1]


class ArrayIndexOutOfBoundsException(Exception):
    pass


# TestArray file
if __name__ == "__main__":
    # Test Case 1
    MyArr1 = ArrayMuni(9)
    '''đoạn này là  để định dạng lại cái mảng thành cái mảng cho trước, tới đoạn cần random thì xóa đi'''
    MyArr1.array = [-3, 5, -3, 6, -2, 4, 11, -5, 4]
    '''-------------------------------------------------'''
    print("MyArr1:", MyArr1.to_string())
    try:
        print("Geti(0):", MyArr1.geti(0))
        print("Geti(2):", MyArr1.geti(2))
        print("Geti(10):", MyArr1.geti(10))
    except ArrayIndexOutOfBoundsException as e:
        print("Error:", e)

    # Test Case 2
    MyArr2 = ArrayMuni(10)
    MyArr2.array = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
    print("\nMyArr2:", MyArr2.to_string())

    # Test Case 3
    MyArr3 = ArrayMuni(5)
    MyArr3.array = [5, 4, -1, 7, 8]
    print("\nMyArr3:", MyArr3.to_string())
    print("Subarray with maximum sum:", MyArr3.subarray())

    # Test Case 4
    MyArr4 = ArrayMuni(20)
    print("\nMyArr4:", MyArr4.to_string())
