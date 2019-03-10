package lab3.car;

class Car {
    boolean engineState = false;
    String direction = "stay";
    int speed;
    int gear = 0;

    boolean TurnOnEngine() {
        if (!engineState) {
            engineState = true;
        }
        return engineState;
    }

    boolean TurnOffEngine() {
        if (engineState && gear == 0 && direction.equals("stay")) {
            engineState = false;
        }
        if (!engineState) {
            return true;
        } else {
            return false;
        }
    }

    boolean SetGear(int gear) {
        if (gear > 0) {
            if (!direction.equals("back") && speed != 0) {
                this.direction = "forward";
            }
        } else if (gear < 0 && this.gear == 0) {
            this.direction = "back";
        } else if (gear == 0 && speed == 0) {
            this.direction = "stay";
        }
        boolean forward = direction.equals("forward");
        boolean stay = direction.equals("stay");
        boolean back = direction.equals("back");
        if (!engineState) {
            if (gear == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (gear == -1 && speed == 0 && (stay || back)) {
            this.gear = -1;
            this.direction = "stay";
            return true;
        } else if (gear == 0 && 0 <= speed && speed <= 150) {
            this.gear = 0;
            return true;
        } else if (gear == 1 && 0 <= speed && speed <= 30 && (forward || stay)) {
            if (this.gear == -1 && speed == 0) {
                this.gear = 1;
                return true;
            }
            if (this.gear == -1 && speed != 0 && stay) {
                this.gear = 1;
                return true;
            }

            if (this.gear != -1) {
                this.gear = 1;
                return true;
            }
        } else if (gear == 2 && 20 <= speed && speed <= 50 && forward) {
            this.gear = 2;
            return true;
        } else if (gear == 3 && 30 <= speed && speed <= 60 && forward) {
            this.gear = 3;
            return true;
        } else if (gear == 4 && 40 <= speed && speed <= 90 && forward) {
            this.gear = 4;
            return true;
        } else if (gear == 5 && 50 <= speed && speed <= 150 && forward) {
            this.gear = 5;
            return true;
        }
        return false;
    }

    boolean SetSpeed(int speed) {
        boolean condition =
            speed >= 0 && speed <= 20 && this.gear == -1 ||
                speed >= 0 && speed <= 150 && this.gear == 0 && speed <= this.speed ||
                speed >= 0 && speed <= 30 && this.gear == 1 ||
                speed >= 20 && speed <= 50 && this.gear == 2 ||
                speed >= 30 && speed <= 60 && this.gear == 3 ||
                speed >= 40 && speed <= 90 && this.gear == 4 ||
                speed >= 50 && speed <= 150 && this.gear == 5;
        if (gear == -1 && speed != 0) {
            direction = "back";
        }
        if (gear == 0 && speed == 0) {
            direction = "stay";
        }
        if (gear > 0 && speed > 0 && condition) {
            direction = "forward";
        }
        if (condition) {
            this.speed = speed;
            return true;
        }
        return false;
    }
}
