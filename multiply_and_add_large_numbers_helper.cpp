// Online C++ compiler to run C++ program online
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
// helper;
char itoa(int s) {
    return '0' + s;
}
// helper;
int stoi(char x) {
    return x - '0';
}

struct BigNumber {
    string number = "";
    bool updated = false;
    deque<char> digits;
    
    void make_number() {
        number = "";
        for (int i = 0; i < digits.size(); i++) {
            number += digits[i];
        }
        updated = false;
    }
    
    void add_digit_back(char digit) {
        digits.push_back(digit);
        updated = true;
    }
    
    void add_digit_front(char digit) {
        digits.push_front(digit);
        updated = true;
    }
    
    string get_number() {
        if (updated) {
            make_number();
        }
        if (number == "") return "0";
        return number;
    }
};

// only positive numbers;
string add(string a, string b) {
    if (b.length() > a.length()) {
        return add(b, a);
    }
    
    int carry = 0;
    BigNumber sum;
    int b_end = b.length()-1;
    int a_end = a.length()-1;
    for (; b_end >= 0; b_end--) {
       // cout << "adding " << a[a_end] << " and " << b[b_end] << endl;
        sum.add_digit_front(itoa((stoi(b[b_end]) + stoi(a[a_end]) + carry) % 10));
        
        carry = (stoi(b[b_end]) + stoi(a[a_end]) + carry) /10;
        a_end --;
    }
    
    // now for the remaining values;
    for (; a_end >= 0; a_end--) {
        sum.add_digit_front(itoa((stoi(a[a_end]) + carry) % 10));
        carry = ((stoi(a[a_end]) + carry)/10);
    }
    
    while (carry > 0) {
        sum.add_digit_front(itoa(carry % 10));
        carry /= 10;
    }
    
    return sum.get_number();
}


// need zero strip;
string mul(string a, string b) {
    // mulitply a by b;
    int carry = 0;
    // mulitply the smaller number across each o the larger
    if (a.length() < b.length()) return mul(b, a);
    
    // b is smaller, a is larger;
    string product = "0";
    for (int i = b.length()-1; i >= 0; i--) {
        carry = 0;
        BigNumber row;
        // add (b.length()-1 - i) zeros to the bigNumber;
        for (int zeros = 0; zeros < (b.length()-1 - i); zeros ++) {
            row.add_digit_back('0');
        }
        
        for (int j = a.length()-1; j >= 0; j--) {
            int tmp = stoi(a[j]) * stoi(b[i]) + carry;
            row.add_digit_front(itoa(tmp % 10));
            carry = tmp / 10;
        }
        
        while (carry > 0) {
            row.add_digit_front(itoa(carry % 10));
            carry /= 10;
        }
        
        product = add(product, row.get_number());
    }
    return product;
}