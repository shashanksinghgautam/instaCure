import { Pipe, PipeTransform } from '@angular/core';
import { Medicine } from './medicine';
@Pipe({
  name: 'search',
})
export class SearchPipe implements PipeTransform {
  transform(contacts: any, searchText: any): any {
    searchText = searchText.toLowerCase();
    if (searchText == '') {
      return contacts;
    } else {
      return contacts.filter((item: { medicinename: string }) =>
        (item.medicinename || '').toLowerCase().includes(searchText)
      );
    }
  }
}
