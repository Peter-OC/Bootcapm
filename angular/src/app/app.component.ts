import { Component } from '@angular/core';
import { LoggerService } from 'src/lib/my-core';
import { NotificationService } from './common-services';
import { NavigationService } from './common-services/navigation.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(nav: NavigationService) {}

  // constructor(private out: LoggerService) {
  //   out.error('Es un error')
  //   out.warn('Es un warn')
  //   out.info('Es un info')
  //   out.log('Es un log')
  // }
}
