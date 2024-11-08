package Main;

public class StudentDetails extends StudentInfo{
    
        private String gender;
        private String phoneNumber;
        private String address;
        private String birthDate;
        private String placeOfBirth;
        public StudentDetails(String lastName, String firstName, String middleName, int age, String gender, String phoneNumber, String address, String birthDate) {
            super(lastName, firstName, middleName, age); 
            this.gender = gender;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.birthDate = birthDate;
            this.placeOfBirth = placeOfBirth;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }
        public void setPlaceOfBirth(String placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }
        public String getGender() {
            return gender;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public String getAddress() {
            return address;
        }
        public String getBirthDate() {
            return birthDate;
        }
        public String getPlaceOfBirth() {
            return placeOfBirth;
        }
}
