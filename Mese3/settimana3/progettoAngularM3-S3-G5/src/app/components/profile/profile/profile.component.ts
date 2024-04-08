import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { User } from 'src/app/models/db-interface';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  user!:User|null;
constructor(private userSrv:UserService,private authSub:AuthService,) { 
}
ngOnInit(): void {
  this.userSrv.getProfile().subscribe(
    (data) => {
     this.user = data[0];
    }
  );
}
logout() {
  this.authSub.logout();
  }
}

