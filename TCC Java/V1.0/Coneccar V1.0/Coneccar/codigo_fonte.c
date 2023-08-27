#include <stdio.h>

struct Student {
    char name[50];
    int age;
    float gpa;
};

int factorial(int n) {
    if (n <= 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
//AI AIA AI
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
//UY UY Y
int main() {
    int numbers[] = {5, 2, 8, 12, 3};
    int size = sizeof(numbers) / sizeof(numbers[0]);

    printf("Original array: ");
    printArray(numbers, size);

    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }

    printf("Sorted array: ");
    printArray(numbers, size);

    struct Student student1;
    strcpy(student1.name, "Alice");
    student1.age = 20 ;
    student1.gpa = 3.75 ;

    printf("Student: %s, Age: %d, GPA: %.2f\n", student1.name, student1.age, student1.gpa);

    int num = 5;
    int fact = factorial(num);
    printf("Factorial of %d is %d\n", num, fact);

    return 0;
}

